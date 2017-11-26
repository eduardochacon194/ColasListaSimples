package Queue;

import java.util.Iterator;
import node.node;

public class Queue<T extends Comparable<T>> implements iQueue<T>, Iterable<T> {
	
	private int tam = 0;
	private int count = 0;
	private node<T> sentinel = null;
	private node<T> tmp = null;
	node<T> entrada;
	
	public Queue()
	{
		sentinel = new node<T>();
		sentinel.setIndex(-1);
		tam = 10;
	}
	
	public Queue(int tam)
	{
		this();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			node<T> extra = sentinel.getNext();
			@Override
			public boolean hasNext() 
			{
				System.out.println(extra.getValue());
				extra = extra.getNext();
				return (extra != sentinel.getNext());
			}
			@Override
			public T next() 
			{
				return extra.getValue();
			}
		};
	}

	@Override
	public void enQueue(T value) throws QueueFullException 
	{
		if (isFull()) throw new QueueFullException("Cola Llena Por De Quitar Elementos");
		tmp = sentinel.getNext();
		entrada = new node<T>(value);
		if(isEmpty())
		{
			sentinel.setNext(entrada);
			entrada.setNext(entrada);
			
		}
		else if(!isFull())
		{
			while(!tmp.getNext().equals(sentinel.getNext())) 
			{
				tmp = tmp.getNext();
			}
			tmp.setNext(entrada);
			entrada.setNext(sentinel.getNext());
		}
		count++;
	}

	@Override
	public T deQueue() throws QueueEmptyException 
	{
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		if(size() > 1) 
		{
			tmp = buscanuevo(front(), sentinel.getNext());
			sentinel.setNext(sentinel.getNext().getNext());
			tmp.setNext(tmp.getNext().getNext());
			count--;
			return sentinel.getNext().getValue();
		}
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		return (count == 0);
	}

	@Override
	public boolean isFull() 
	{
		return (count == tam);
	}

	@Override
	public T front() throws QueueEmptyException {
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		if(!isEmpty())
		{
			return sentinel.getNext().getValue();
		}
		return null;
	}
	private node<T> buscanuevo(T value, node<T> lista)
	{
		if(lista.getNext().getValue().equals(value))
		{
			return lista;
		}
		return buscanuevo(value, lista.getNext());
	}
	@Override
	public T search(T value) throws QueueEmptyException 
	{
		if (isEmpty()) throw new QueueEmptyException("Cola Vacia Por Favor De Llenar");
		return search(value, sentinel.getNext());
	}
	private T search(T value, node<T> lista)
	{
		if(lista.getNext().getValue().equals(value))
		{
			return lista.getNext().getValue();
		}
		return search(value, lista.getNext());
	}

	@Override
	public void clear() 
	{
		sentinel.setNext(null);
        count = 0;
	}

	@Override
	public boolean frontOf(T value, int priority) throws QueueFullException 
	{
		return false;
	}

	@Override
	public int size() 
	{
		return count;
	}
}
