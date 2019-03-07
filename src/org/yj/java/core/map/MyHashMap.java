package org.yj.java.core.map;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/1/7 18:45
 */
public class MyHashMap<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 整型的最大值是2^31-1，所以不超过整型最大值的2的幂次是2^30(1<<30)
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    int threshold;

    final float loadFactor;

    int size;

    Node<K, V>[] table;

    class Node<K, V> {
        /**
         * 代替
         */
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "hash=" + hash + ", key=" + key + ", value=" + value + '}';
        }
    }

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    private Node<K, V>[] resize() {
        // table的引用
        Node<K, V>[] oldTab = table;
        // 老的容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 老的resize触发阈值
        int oldThr = threshold;
        // 新的容量
        int newCap = 0;
        // 新的resize触发阈值
        int newThr = 0;
        if (oldCap > 0) {
            // 不是第一次resize
            if (oldCap >= MAXIMUM_CAPACITY) {
                // 当前容量已经是容量最大值，resize的触发阈值设置为整型最大值
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldThr > DEFAULT_INITIAL_CAPACITY) {
                // 新的容量<最大容量 且 当前resize触发阈值>默认初始容量，则新的threshold为当前threshold*2
                // 之所以要判断当前resize触发阈值>默认初始容量我觉得是为了防止用户设置的初始容量或加载因子过小，导致threshold*2和oldCap*2*loadFactor的结果不一致
                // 举例来说：假设用户设置的初始容量为2、loadFactor为0.75，那么threshold初始为1
                // 当第一次发生resize时，如果只是将threshold结果翻倍，结果是2，而容量翻倍后是4，乘以loadFactor之后是3，两个结果不一致
                // 但是当容量为4之后的resize其实threshold*2和oldCap*2*loadFactor的结果时一样的
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            // 第一次resize且用户指定了初始容量，初始容量会记在threshold中
            newCap = oldThr;
        } else {
            // 第一次resize且用户没有指定初始容量
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            // 以下几种情况会进当前if：
            // 1.不是第一次resize且oldCap<最大容量且newCap==最大容量(理论上不存在newCap>最大容量的情况)
            // 2.第一次resize且用户设置了初始容量
            float ft = newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        return table;
    }

    /**
     * 返回大于cap的最小2的幂次
     * 
     * @param cap 传入的初始容量
     * @return 大于cap的最小2的幂次
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public V put(K key, V value) {
        // table的引用
        Node<K, V>[] tab;
        // table中被散列到的链表的首个元素
        Node<K, V> p;
        // 桶的个数，即table的长度
        int n;
        // 桶的个数-1
        int i;

        // 重新计算key的hash值，为了后面散列更均匀
        int hash = hash(key);

        tab = table;
        if (tab == null || (n = tab.length) == 0) {
            // 第一次put，table还没有初始化
            tab = resize();
            n = tab.length;
        }
        i = n - 1;
        // 散列算法的基本思想就是根据桶的数量取余，将键值对放到不同的桶中，用%运算的话效率比较低，而用位运算效率能提高很多
        // 考虑十进制取余，如果十进制数对10的n次幂取余，那么这个余数一定是十进制数从个位开始截取n位，例如：999%10=9，999%100=99。
        // 同理，二进制数如果对2的n次幂取余，这个余数也会是二进制数从低位开始截取n位，等同于二进制数按位与上2的n次幂-1
        // 所以在HashMap中桶的数量必须为2的幂次，这时就可以使用位运算来代替取模运算了
        i = i & hash;
        p = tab[i & hash];
        if (p == null) {
            // 被散列到的位置没有任何数据
            tab[i] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> e;
            // 被散列到的位置有数据，遍历链表是否有重复的key，有就更新数据，没有就插入到链表的末尾
            if (p.getHash() == hash && (p.getKey() == key || (key != null && key.equals(p.getKey())))) {
                e = p;
            } else {
                for (int binCount = 0;; binCount++) {
                    e = p.next;
                    if (e == null) {
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    } else {
                        if (p.getHash() == hash && (p.getKey() == key || (key != null && key.equals(p.getKey())))) {
                            e = p;
                            break;
                        }
                    }
                }
            }

            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        if (++size > threshold) {
            resize();
        }
        return null;
    }

    public V get(Object key) {
        int hash = hash(key);
        int n;
        int i;
        Node<K, V>[] tab = table;
        Node<K, V> p;
        if (tab != null) {
            n = tab.length;
            i = n - 1;
            p = tab[hash & i];
            if (p == null) {
                return null;
            }
            if (p.getHash() == hash && ((p.getKey() == key) || p.getKey().equals(key))) {
                return p.getValue();
            }
            Node<K, V> e = p.next;
            while (e != null) {
                if (e.getHash() == hash && ((e.getKey() == key) || e.getKey().equals(key))) {
                    return e.getValue();
                }
                e = e.next;
            }
        }
        return null;
    }

    /**
     * 重新计算对象的hashcode，为了使后面散列得更均匀
     * 
     * @param key
     * @return
     */
    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int hashcode = key.hashCode();
        // 哈希值的高位2字节干扰低位2字节，防止桶的数量较少时，散列不均匀
        return hashcode ^ (hashcode >>> 16);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyHashMap{").append("\n");
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                sb.append("\t");
                if (table[i] != null) {
                    Node<K, V> e = table[i];
                    while (e != null) {
                        sb.append(e.toString()).append(",");
                        e = e.next;
                    }
                }
                sb.append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(0, "0");
        myHashMap.put(1, "1");
        myHashMap.put(2, "2");
        myHashMap.put(3, "3");
        myHashMap.put(4, "4");
        myHashMap.put(5, "5");
        myHashMap.put(6, "6");
        myHashMap.put(6, "6");
        myHashMap.put(65, "65");
        System.out.println(myHashMap);
        System.out.println(myHashMap.get(65));

    }
}
