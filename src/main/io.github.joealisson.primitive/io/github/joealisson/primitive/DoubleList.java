package io.github.joealisson.primitive;

import java.util.*;
import java.util.function.DoubleUnaryOperator;

/**
 * An ordered collection (also known as a <i>sequence</i>).  The user of this
 * interface has precise control over where in the list each element is
 * inserted.  The user can access elements by their integer index (position in
 * the list), and search for elements in the list.<p>
 *
 * Unlike sets, lists typically allow duplicate elements.  More formally,
 * lists typically allow pairs of elements {@code e1} and {@code e2}
 * such that {@code e1.equals(e2)}, and they typically allow multiple
 * null elements if they allow null elements at all.  It is not inconceivable
 * that someone might wish to implement a list that prohibits duplicates, by
 * throwing runtime exceptions when the user attempts to insert them, but we
 * expect this usage to be rare.<p>
 *
 * The {@code List} interface places additional stipulations, beyond those
 * specified in the {@code Collection} interface, on the contracts of the
 * {@code iterator}, {@code add}, {@code remove}, {@code equals}, and
 * {@code hashCode} methods.  Declarations for other inherited methods are
 * also included here for convenience.<p>
 *
 * The {@code List} interface provides four methods for positional (indexed)
 * access to list elements.  Lists (like Java arrays) are zero based.  Note
 * that these operations may execute in time proportional to the index value
 * for some implementations (the {@code LinkedList} class, for
 * example). Thus, iterating over the elements in a list is typically
 * preferable to indexing through it if the caller does not know the
 * implementation.<p>
 *
 * The {@code List} interface provides a special iterator, called a
 * {@code ListIterator}, that allows element insertion and replacement, and
 * bidirectional access in addition to the normal operations that the
 * {@code Iterator} interface provides.  A method is provided to obtain a
 * list iterator that starts at a specified position in the list.<p>
 *
 * The {@code List} interface provides two methods to search for a specified
 * object.  From a performance standpoint, these methods should be used with
 * caution.  In many implementations they will perform costly linear
 * searches.<p>
 *
 * The {@code List} interface provides two methods to efficiently insert and
 * remove multiple elements at an arbitrary point in the list.<p>
 *
 * Note: While it is permissible for lists to contain themselves as elements,
 * extreme caution is advised: the {@code equals} and {@code hashCode}
 * methods are no longer well defined on such a list.
 *
 * <p>Some list implementations have restrictions on the elements that
 * they may contain.  For example, some implementations prohibit null elements,
 * and some have restrictions on the types of their elements.  Attempting to
 * add an ineligible element throws an unchecked exception, typically
 * {@code NullPointerException} or {@code ClassCastException}.  Attempting
 * to query the presence of an ineligible element may throw an exception,
 * or it may simply return false; some implementations will exhibit the former
 * behavior and some will exhibit the latter.  More generally, attempting an
 * operation on an ineligible element whose completion would not result in
 * the insertion of an ineligible element into the list may throw an
 * exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 *
 * <h2><a id="unmodifiable">Unmodifiable Lists</a></h2>
 * <p>The {@link List#of(Object...) List.of} and
 * {@link List#copyOf List.copyOf} static factory methods
 * provide a convenient way to create unmodifiable lists. The {@code List}
 * instances created by these methods have the following characteristics:
 *
 * <ul>
 * <li>They are <a href="Collection.html#unmodifiable"><i>unmodifiable</i></a>. Elements cannot
 * be added, removed, or replaced. Calling any mutator method on the List
 * will always cause {@code UnsupportedOperationException} to be thrown.
 * However, if the contained elements are themselves mutable,
 * this may cause the List's contents to appear to change.
 * <li>They disallow {@code null} elements. Attempts to create them with
 * {@code null} elements result in {@code NullPointerException}.
 * <li>They are serializable if all elements are serializable.
 * <li>The order of elements in the list is the same as the order of the
 * provided arguments, or of the elements in the provided array.
 * <li>They are <a href="../lang/doc-files/ValueBased.html">value-based</a>.
 * Callers should make no assumptions about the identity of the returned instances.
 * Factories are free to create new instances or reuse existing ones. Therefore,
 * identity-sensitive operations on these instances (reference equality ({@code ==}),
 * identity hash code, and synchronization) are unreliable and should be avoided.
 * <li>They are serialized as specified on the
 * <a href="{@docRoot}/serialized-form.html#java.util.CollSer">Serialized Form</a>
 * page.
 * </ul>
 *
 * <p>This interface is a member of the
 * <a href="{@docRoot}/java.base/java/util/package-summary.html#CollectionsFramework">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see Collection
 * @see Set
 * @see ArrayList
 * @see LinkedList
 * @see Vector
 * @see Arrays#asList(Object[])
 * @see Collections#nCopies(int, Object)
 * @see Collections#EMPTY_LIST
 * @see AbstractList
 * @see AbstractSequentialList
 * @since 1.2
 */

public interface DoubleList extends DoubleCollection {


	/**
	 * Appends the specified element to the end of this list (optional
	 * operation).
	 *
	 * <p>Lists that support this operation may place limitations on what
	 * elements may be added to this list.  In particular, some
	 * lists will refuse to add null elements, and others will impose
	 * restrictions on the type of elements that may be added.  List
	 * classes should clearly specify in their documentation any restrictions
	 * on what elements may be added.
	 *
	 * @param e element to be appended to this list
	 * @return {@code true} (as specified by {@link Collection#add})
	 * @throws UnsupportedOperationException if the {@code add} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws IllegalArgumentException if some property of this element
	 *         prevents it from being added to this list
	 */
	boolean add(double e);

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present (optional operation).  If this list does not contain
	 * the element, it is unchanged.  More formally, removes the element with
	 * the lowest index {@code i} such that
	 * {@code Objects.equals(o, get(i))}
	 * (if such an element exists).  Returns {@code true} if this list
	 * contained the specified element (or equivalently, if this list changed
	 * as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return {@code true} if this list contained the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws UnsupportedOperationException if the {@code remove} operation
	 *         is not supported by this list
	 */
	boolean remove(double o);


	// Bulk Modification Operations

	/**
	 * Returns {@code true} if this list contains all of the elements of the
	 * specified collection.
	 *
	 * @param  c collection to be checked for containment in this list
	 * @return {@code true} if this list contains all of the elements of the
	 *         specified collection
	 * @throws ClassCastException if the types of one or more elements
	 *         in the specified collection are incompatible with this
	 *         list
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #contains(double)
	 */
	boolean containsAll(DoubleCollection c);

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's iterator (optional operation).  The behavior of this
	 * operation is undefined if the specified collection is modified while
	 * the operation is in progress.  (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 *
	 * @param c collection containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code addAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 * @see #add(double)
	 */
	boolean addAll(DoubleCollection c);

	/**
	 * Inserts all of the elements in the specified collection into this
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).  The new elements
	 * will appear in this list in the order that they are returned by the
	 * specified collection's iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param c collection containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code addAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	boolean addAll(int index, DoubleCollection c);

	/**
	 * Inserts all of the elements in the specified array into this
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).  The new elements
	 * will appear in this list in the order that they are returned by the
	 * specified collection's iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param array array containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code addAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	boolean addAll(int index, double[] array);

	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection (optional operation).
	 *
	 * @param c collection containing elements to be removed from this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code removeAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(double)
	 * @see #contains(double)
	 */
	boolean removeAll(DoubleCollection c);

	/**
	 * Retains only the elements in this list that are contained in the
	 * specified collection (optional operation).  In other words, removes
	 * from this list all of its elements that are not contained in the
	 * specified collection.
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code retainAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(double)
	 * @see #contains(double)
	 */
	boolean retainAll(DoubleCollection c);

	/**
	 * Replaces each element of this list with the result of applying the
	 * operator to that element.  Errors or runtime exceptions thrown by
	 * the operator are relayed to the caller.
	 *
	 * <pre>{@code
	 *     final ListIterator<E> li = list.listIterator();
	 *     while (li.hasNext()) {
	 *         li.set(operator.apply(li.next()));
	 *     }
	 * }</pre>
	 *
	 * If the list's list-iterator does not support the {@code set} operation
	 * then an {@code UnsupportedOperationException} will be thrown when
	 * replacing the first element.
	 *
	 * @param operator the operator to apply to each element
	 * @throws UnsupportedOperationException if this list is unmodifiable.
	 *         Implementations may throw this exception if an element
	 *         cannot be replaced or if, in general, modification is not
	 *         supported
	 * @throws NullPointerException if the specified operator is null or
	 *         if the operator result is a null value and this list does
	 *         not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @since 1.8
	 */
	default void replaceAll(DoubleUnaryOperator operator) {
		Objects.requireNonNull(operator);
		final DoubleListIterator li = this.listIterator();
		while (li.hasNext()) {
			li.set(operator.applyAsDouble(li.nextDouble()));
		}
	}

	/**
	 * Sorts this list according to the order induced by the specified
	 * {@link Comparator}.  The sort is <i>stable</i>: this method must not
	 * reorder equal elements.
	 *
	 * <p>All elements in this list must be <i>mutually comparable</i> using the
	 * specified comparator (that is, {@code c.compare(e1, e2)} must not throw
	 * a {@code ClassCastException} for any elements {@code e1} and {@code e2}
	 * in the list).
	 *
	 * <p>If the specified comparator is {@code null} then all elements in this
	 * list must implement the {@link Comparable} interface and the elements'
	 * {@linkplain Comparable natural ordering} should be used.
	 *
	 * <p>This list must be modifiable, but need not be resizable.
	 *
	 * The default implementation obtains an array containing all elements in
	 * this list, sorts the array, and iterates over this list resetting each
	 * element from the corresponding position in the array. (This avoids the
	 * n<sup>2</sup> log(n) performance that would result from attempting
	 * to sort a linked list in place.)
	 *
	 * This implementation is a stable, adaptive, iterative mergesort that
	 * requires far fewer than n lg(n) comparisons when the input array is
	 * partially sorted, while offering the performance of a traditional
	 * mergesort when the input array is randomly ordered.  If the input array
	 * is nearly sorted, the implementation requires approximately n
	 * comparisons.  Temporary storage requirements vary from a small constant
	 * for nearly sorted input arrays to n/2 object references for randomly
	 * ordered input arrays.
	 *
	 * <p>The implementation takes equal advantage of ascending and
	 * descending order in its input array, and can take advantage of
	 * ascending and descending order in different parts of the same
	 * input array.  It is well-suited to merging two or more sorted arrays:
	 * simply concatenate the arrays and sort the resulting array.
	 *
	 * <p>The implementation was adapted from Tim Peters's list sort for Python
	 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
	 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
	 * Sorting and Information Theoretic Complexity", in Proceedings of the
	 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
	 * January 1993.
	 *
	 * @throws ClassCastException if the list contains elements that are not
	 *         <i>mutually comparable</i> using the specified comparator
	 * @throws UnsupportedOperationException if the list's list-iterator does
	 *         not support the {@code set} operation
	 * @throws IllegalArgumentException
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 *         if the comparator is found to violate the {@link Comparator}
	 *         contract
	 * @since 1.8
	 */
	@SuppressWarnings({"rawtypes"})
	default void sort() {
		double[] a = this.toArray();
		Arrays.sort(a);
		DoubleListIterator i = this.listIterator();
		for (double e : a) {
			i.nextDouble();
			i.set(e);
		}
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * The list will be empty after this call returns.
	 *
	 * @throws UnsupportedOperationException if the {@code clear} operation
	 *         is not supported by this list
	 */
	void clear();


	// Comparison and hashing

	/**
	 * Compares the specified object with this list for equality.  Returns
	 * {@code true} if and only if the specified object is also a list, both
	 * lists have the same size, and all corresponding pairs of elements in
	 * the two lists are <i>equal</i>.  (Two elements {@code e1} and
	 * {@code e2} are <i>equal</i> if {@code Objects.equals(e1, e2)}.)
	 * In other words, two lists are defined to be
	 * equal if they contain the same elements in the same order.  This
	 * definition ensures that the equals method works properly across
	 * different implementations of the {@code List} interface.
	 *
	 * @param o the object to be compared for equality with this list
	 * @return {@code true} if the specified object is equal to this list
	 */
	boolean equals(Object o);

	/**
	 * Returns the hash code value for this list.  The hash code of a list
	 * is defined to be the result of the following calculation:
	 * <pre>{@code
	 *     int hashCode = 1;
	 *     for (E e : list)
	 *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
	 * }</pre>
	 * This ensures that {@code list1.equals(list2)} implies that
	 * {@code list1.hashCode()==list2.hashCode()} for any two lists,
	 * {@code list1} and {@code list2}, as required by the general
	 * contract of {@link Object#hashCode}.
	 *
	 * @return the hash code value for this list
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	int hashCode();


	// Positional Access Operations

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	double get(int index);

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 *
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws UnsupportedOperationException if the {@code set} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	double set(int index, double element);

	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation).  Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (adds one to their
	 * indices).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws UnsupportedOperationException if the {@code add} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	void add(int index, double element);

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation).  Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * list.
	 *
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws UnsupportedOperationException if the {@code remove} operation
	 *         is not supported by this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	double removeFromIndex(int index);


	// Search Operations

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the lowest index {@code i} such that
	 * {@code Objects.equals(o, get(i))},
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	int indexOf(double o);

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the highest index {@code i} such that
	 * {@code Objects.equals(o, get(i))},
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	int lastIndexOf(double o);


	// List Iterators

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 *
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 */
	DoubleListIterator listIterator();

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence), starting at the specified position in the list.
	 * The specified index indicates the first element that would be
	 * returned by an initial call to {@link ListIterator#next next}.
	 * An initial call to {@link ListIterator#previous previous} would
	 * return the element with the specified index minus one.
	 *
	 * @param index index of the first element to be returned from the
	 *        list iterator (by a call to {@link ListIterator#next next})
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence), starting at the specified position in the list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	DoubleListIterator listIterator(int index);

	// View

	/**
	 * Returns a view of the portion of this list between the specified
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
	 * {@code fromIndex} and {@code toIndex} are equal, the returned list is
	 * empty.)  The returned list is backed by this list, so non-structural
	 * changes in the returned list are reflected in this list, and vice-versa.
	 * The returned list supports all of the optional list operations supported
	 * by this list.<p>
	 *
	 * This method eliminates the need for explicit range operations (of
	 * the sort that commonly exist for arrays).  Any operation that expects
	 * a list can be used as a range operation by passing a subList view
	 * instead of a whole list.  For example, the following idiom
	 * removes a range of elements from a list:
	 * <pre>{@code
	 *      list.subList(from, to).clear();
	 * }</pre>
	 * Similar idioms may be constructed for {@code indexOf} and
	 * {@code lastIndexOf}, and all of the algorithms in the
	 * {@code Collections} class can be applied to a subList.<p>
	 *
	 * The semantics of the list returned by this method become undefined if
	 * the backing list (i.e., this list) is <i>structurally modified</i> in
	 * any way other than via the returned list.  (Structural modifications are
	 * those that change the size of this list, or otherwise perturb it in such
	 * a fashion that iterations in progress may yield incorrect results.)
	 *
	 * @param fromIndex low endpoint (inclusive) of the subList
	 * @param toIndex high endpoint (exclusive) of the subList
	 * @return a view of the specified range within this list
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value
	 *         ({@code fromIndex < 0 || toIndex > size ||
	 *         fromIndex > toIndex})
	 */
	DoubleList subList(int fromIndex, int toIndex);

	/**
	 * Creates a {@link Spliterator} over the elements in this list.
	 *
	 * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
	 * {@link Spliterator#ORDERED}.  Implementations should document the
	 * reporting of additional characteristic values.
	 *
	 * The default implementation creates a
	 * <em><a href="Spliterator.html#binding">late-binding</a></em>
	 * spliterator as follows:
	 * <ul>
	 * <li>If the list is an instance of {@link RandomAccess} then the default
	 *     implementation creates a spliterator that traverses elements by
	 *     invoking the method {@link List#get}.  If such invocation results or
	 *     would result in an {@code IndexOutOfBoundsException} then the
	 *     spliterator will <em>fail-fast</em> and throw a
	 *     {@code ConcurrentModificationException}.
	 *     If the list is also an instance of {@link AbstractIntList} then the
	 *     spliterator will use the list's {@link AbstractIntList#modCount modCount}
	 *     field to provide additional <em>fail-fast</em> behavior.
	 * <li>Otherwise, the default implementation creates a spliterator from the
	 *     list's {@code Iterator}.  The spliterator inherits the
	 *     <em>fail-fast</em> of the list's iterator.
	 * </ul>
	 *
	 * The created {@code Spliterator} additionally reports
	 * {@link Spliterator#SUBSIZED}.
	 *
	 * @return a {@code Spliterator} over the elements in this list
	 * @since 1.8
	 */
	@Override
	default Spliterator.OfDouble spliterator() {
		if (this instanceof RandomAccess) {
			return new AbstractDoubleList.RandomAccessSpliterator(this);
		} else {
			return Spliterators.spliterator(iterator(), size(), Spliterator.ORDERED);
		}
	}

	/**
	 * Returns an unmodifiable list containing zero elements.
	 *
	 * See <a href="#unmodifiable">Unmodifiable Lists</a> for details.
	 *
	 * @return an empty {@code List}
	 *
	 * @since 9
	 */
	static DoubleList of() {
		return Containers.emptyDoubleList();
	}

	/**
	 * Returns an unmodifiable list containing one element.
	 *
	 * See <a href="#unmodifiable">Unmodifiable Lists</a> for details.
	 *
	 * @param e1 the single element
	 * @return a {@code List} containing the specified element
	 * @throws NullPointerException if the element is {@code null}
	 *
	 * @since 9
	 */
	static DoubleList of(double e1) {
		return Containers.singletonDoubleList(e1);
	}
}
