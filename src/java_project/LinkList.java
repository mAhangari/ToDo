package java_project;

import java.util.Iterator;

public class LinkList<E> implements Iterable<E>{
	
	private int size = 0;
	Node<E> first;
	Node<E> last;
	
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> current = first;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				E element = current.item;
				current = current.next;
				return element;
			}
		};
	}

	public boolean add(E e) {
		linkLast(e);
		return true;
	}

	public boolean remove(Object o) {
		for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
		return false;
	}

	public E get(int index) {
        return node(index).item;
	}

	public void set(int index, E element) {
		Node<E> n = node(index);
        n.item = element;
	}

	public E remove(int index) {
		if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return unlink(node(index));
	}

	public int indexOf(Object o) {
		int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item))
                return index;
            index++;
        }
        return -1;
	}

	void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
	
	private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }
	
	private Node<E> node(int index) {
		if(index <= size/2) {
		    Node<E> x = first;
		    for (int i = 0; i < index; i++)
		        x = x.next;
		    return x;
		}
		else {
			Node<E> x = last;
		    for (int i = size - 1; i > index; i--)
		        x = x.prev;
			return x;
		}
	}
	
}
