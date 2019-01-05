package org.yj.java.core.Collection;

import java.util.NoSuchElementException;

/**
 * @author yaojun
 * @version 1.0
 * @date 2019/1/3 19:24
 */
public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    class Node<E> {
        Node<E> prev;
        Node<E> next;
        E item;

        Node(Node<E> prev, Node<E> next, E item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    public MyLinkedList() {}

    public boolean add(E e) {
        Node<E> node = new Node<>(last, null, e);
        if (first == null) {
            first = node;
        }
        if (last != null) {
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }

    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.item;

    }

    public E removeFirst() {
        Node<E> node = first;
        if (node == null) {
            throw new NoSuchElementException();
        }
        unlinkNode(node);
        return node.item;
    }

    public E removeLast() {
        Node<E> node = last;
        if (node == null) {
            throw new NoSuchElementException();
        }
        unlinkNode(node);
        return node.item;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.item == null) {
                    unlinkNode(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.item)) {
                    unlinkNode(node);
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        return node(index).item;
    }

    public E set(int index, E element) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> node = node(index);
        E oldVal = node.item;
        node.item = element;
        return oldVal;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> newNode = new Node<>(prev, node, element);
        node.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            // 从前往后找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            // 从后往前找
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private void unlinkNode(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            last = prev;
        }
        node.prev = null;
        node.next = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> node = first;
        while (node != null) {
            sb.append(node.item).append(",");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        System.out.println(myLinkedList);
        System.out.println("size:" + myLinkedList.size());
        System.out.println("first:" + myLinkedList.getFirst());
        System.out.println("last:" + myLinkedList.getLast());
        System.out.println("removeFirst：" + myLinkedList.removeFirst());
        System.out.println("size:" + myLinkedList.size());
        System.out.println(myLinkedList);
        System.out.println("removeLast：" + myLinkedList.removeLast());
        System.out.println("size:" + myLinkedList.size());
        System.out.println(myLinkedList);
        System.out.println("remove 2:" + myLinkedList.remove("2"));
        System.out.println(myLinkedList);
        myLinkedList.add(0, "1");
        System.out.println(myLinkedList);
        myLinkedList.add(1, "2");
        System.out.println(myLinkedList);
    }
}
