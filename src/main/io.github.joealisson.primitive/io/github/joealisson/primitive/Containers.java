/*
 * Primitive Collection Framework for Java
 * Copyright (C) 2011 napile.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package io.github.joealisson.primitive;

import io.github.joealisson.primitive.function.IntBiFunction;
import io.github.joealisson.primitive.function.LongToLongBiFunction;
import io.github.joealisson.primitive.function.ToLongObjLongBiFunction;
import io.github.joealisson.primitive.iterators.LongIterator;
import io.github.joealisson.primitive.lists.LongList;
import io.github.joealisson.primitive.lists.abstracts.AbstractLongList;
import io.github.joealisson.primitive.pair.IntDouble;
import io.github.joealisson.primitive.pair.IntLong;
import io.github.joealisson.primitive.sets.abstracts.AbstractIntSet;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.ToLongFunction;

/**
 * @author VISTALL
 * @author joeAlisson
 *
 * Some parts from {@link java.util.Collections}
 */
public class Containers
{
    public static final PrimitiveIterator.OfInt EMPTY_INT_ITERATOR = new EmptyIntIterator();
    public static final LongIterator EMPTY_LONG_ITERATOR = new EmptyLongIterator();
    //
    public static final Container EMPTY_CONTAINER = new EmptyContainer();
    //
    public static final IntList EMPTY_INT_LIST = new EmptyIntList();
    public static final LongList EMPTY_LONG_LIST = new EmptyLongList();
    public static final DoubleList EMPTY_DOUBLE_LIST = new EmptyDoubleList();
    //
    private static final IntSet EMPTY_INT_SET = new EmptyIntSet();
    public static final LongSet EMPTY_LONG_SET = new EmptyLongSet();
    //
    @SuppressWarnings("rawtypes")
    private static final IntMap EMPTY_INT_MAP = new EmptyIntMap();
    private static final IntIntMap EMPTY_INT_INT_MAP = new EmptyIntIntMap();
    public static final IntLongMap EMPTY_INT_LONG_MAP = new EmptyIntLongMap();
    public static final MapToLong<?> EMPTY_MAP_TO_LONG = new EmptyMapToLong<>();

    @SuppressWarnings("rawtypes")
    private static final LongMap EMPTY_LONG_OBJECT_MAP = new EmptyLongMap();

    static final int EXPAND_FACTOR = 2;


    /**
     * Return empty instance of IntObjectMap
     *
     * @param <V> the Type of Map
     * @return A map of type V
     */
    @SuppressWarnings("unchecked")
    public static <V> IntMap<V> emptyIntMap() {
        return EMPTY_INT_MAP;
    }

    public static IntIntMap emptyIntIntMap() {
        return EMPTY_INT_INT_MAP;
    }

    @SuppressWarnings("unchecked")
    public static <T> LongMap<T> emptyLongMap() {
        return EMPTY_LONG_OBJECT_MAP;
    }

    public static IntSet emptyIntSet() {
        return EMPTY_INT_SET;
    }

    public static IntList emptyList() { return  EMPTY_INT_LIST; }

    public static IntList singletonIntList(int t)
    {
        return new SingletonIntList(t);
    }

    public static LongList singletonLongList(long t)
    {
        return new SingletonLongList(t);
    }

    public static DoubleList singletonDoubleList(double e) {
        return new SingletonDoubleList(e);
    }

    /**
     * Return simple singleton of iterator if param
     *
     * @param e the base of iterator
     * @return the Map iterator
     */
    public static PrimitiveIterator.OfInt singletonIntIterator(final int e)
    {
        return new SingletonIntIterator(e);
    }

    /**
     * Return simple singleton of iterator if param
     *
     * @param e the base of a iterator.
     * @return the Map iterator
     */
    public static LongIterator singletonLongIterator(final long e)
    {
        return new SingletonLongIterator(e);
    }

    public static PrimitiveIterator.OfDouble singletonDoubleIterator(final double e)
    {
        return new SingletonDoubleIterator(e);
    }

    public static DoubleList emptyDoubleList() {
        return EMPTY_DOUBLE_LIST;
    }

    private static class SingletonIntIterator implements PrimitiveIterator.OfInt
    {
        private boolean _hasNext = true;
        private final int _value;

        public SingletonIntIterator(int value)
        {
            _value = value;
        }

        @Override
        public boolean hasNext()
        {
            return _hasNext;
        }

        @Override
        public int nextInt()
        {
            if(_hasNext)
            {
                _hasNext = false;
                return _value;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static class SingletonLongIterator implements LongIterator
    {
        private boolean _hasNext = true;
        private final long _value;

        public SingletonLongIterator(long value)
        {
            _value = value;
        }

        @Override
        public boolean hasNext()
        {
            return _hasNext;
        }

        @Override
        public long nextLong()
        {
            if(_hasNext)
            {
                _hasNext = false;
                return _value;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static class SingletonIntList extends AbstractIntList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = -6795777618381165134L;

        private final int element;

        SingletonIntList(int obj)
        {
            element = obj;
        }

        @Override
        public PrimitiveIterator.OfInt iterator()
        {
            return singletonIntIterator(element);
        }

        @Override
        public int size()
        {
            return 1;
        }

        @Override
        public boolean contains(int obj)
        {
            return element == obj;
        }

        @Override
        public int get(int index)
        {
            if(index != 0)
            {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: 1");
            }
            return element;
        }
    }

    private static class SingletonLongList extends AbstractLongList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = 4281415105123492902L;

        private final long element;

        SingletonLongList(long obj)
        {
            element = obj;
        }

        @Override
        public LongIterator iterator()
        {
            return singletonLongIterator(element);
        }

        @Override
        public int size()
        {
            return 1;
        }

        @Override
        public boolean contains(long obj)
        {
            return element == obj;
        }

        @Override
        public long get(int index)
        {
            if(index != 0)
            {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: 1");
            }
            return element;
        }
    }

    private static class SingletonDoubleList extends AbstractDoubleList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = -4633338207563639718L;

        private final double element;

        SingletonDoubleList(double obj)
        {
            element = obj;
        }

        @Override
        public PrimitiveIterator.OfDouble iterator()
        {
            return singletonDoubleIterator(element);
        }

        @Override
        public int size()
        {
            return 1;
        }

        @Override
        public boolean contains(double obj)
        {
            return element == obj;
        }

        @Override
        public double get(int index)
        {
            if(index != 0)
            {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: 1");
            }
            return element;
        }
    }

    private static class SingletonDoubleIterator implements PrimitiveIterator.OfDouble
    {
        private boolean _hasNext = true;
        private final double _value;

        public SingletonDoubleIterator(double value)
        {
            _value = value;
        }

        @Override
        public boolean hasNext()
        {
            return _hasNext;
        }

        @Override
        public double nextDouble()
        {
            if(_hasNext)
            {
                _hasNext = false;
                return _value;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static class EmptyIntIterator implements PrimitiveIterator.OfInt
    {
        @Override
        public boolean hasNext()
        {
            return false;
        }

        @Override
        public int nextInt()
        {
            throw new NoSuchElementException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static class EmptyLongIterator implements LongIterator
    {
        @Override
        public boolean hasNext()
        {
            return false;
        }

        @Override
        public long nextLong()
        {
            throw new NoSuchElementException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static abstract class AbstractImmutableIntCollection extends AbstractIntCollection {
        @Override public boolean add(int e) { throw  new UnsupportedOperationException(); }
        @Override public boolean addAll(IntCollection c) { throw new UnsupportedOperationException(); }
        @Override public boolean addAll(int[] array) { throw new UnsupportedOperationException(); }
        @Override public void    clear() { throw new UnsupportedOperationException(); }
        @Override public boolean remove(int o) { throw new UnsupportedOperationException(); }
        @Override public boolean removeAll(IntCollection c) { throw new UnsupportedOperationException(); }
        @Override public boolean removeIf(IntPredicate filter) { throw new UnsupportedOperationException(); }
        @Override public boolean retainAll(IntCollection c) { throw new UnsupportedOperationException(); }
    }

    static abstract class AbstractImmutableIntSet extends AbstractImmutableIntCollection
            implements IntSet {

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof IntSet)) {
                return false;
            }

            IntCollection c = (IntCollection) o;
            if (c.size() != size()) {
                return false;
            }
            for (var it = iterator(); it.hasNext();) {
                if (!contains(it.nextInt())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public abstract int hashCode();
    }

    static final class IntSet12 extends AbstractImmutableIntSet
            implements Serializable {

        private final int e0;
        private final int e1;

        public IntSet12(int e0) {
            this.e0 = e0;
            this.e1 = e0;
        }

        public IntSet12(int e0, int e1) {
            this.e0 = e0;
            this.e1 = e1;
        }

        @Override
        public int size() {
            return e0 == e1 ? 1 : 2;
        }

        @Override
        public boolean contains(int o) {
            return e0 == o || e1 == o;
        }

        @Override
        public int hashCode() {
            return e0 == e1 ? e0 : e0 + e1 << 2;
        }

        @Override
        public PrimitiveIterator.OfInt iterator() {
            return new PrimitiveIterator.OfInt() {
                private int idx = 0;

                @Override
                public boolean hasNext() {
                    return idx < size();
                }

                @Override
                public int nextInt() {
                    if(idx == 0) {
                        idx++;
                        return e0;
                    }else if(idx == 1){
                        idx++;
                        return e1;
                    }
                    else {
                        throw new NoSuchElementException();
                    }
                }
            };
        }
    }

    private static abstract class ImmutabbleIntMap<V> extends AbstractIntMap<V> implements Serializable{
        @Override public void clear() { throw new UnsupportedOperationException(); }
        @Override public V compute(int key, IntBiFunction<? super V,? extends V> rf) { throw new UnsupportedOperationException(); }
        @Override public V computeIfAbsent(int key, IntFunction<? extends V> mf) { throw new UnsupportedOperationException(); }
        @Override public V computeIfPresent(int key, IntBiFunction<? super V,? extends V> rf) { throw new UnsupportedOperationException(); }
        @Override public V merge(int key, V value, BiFunction<? super V,? super V,? extends V> rf) { throw new UnsupportedOperationException(); }
        @Override public V put(int key, V value) { throw new UnsupportedOperationException(); }
        @Override public void putAll(IntMap<? extends V> m) { throw new UnsupportedOperationException(); }
        @Override public V putIfAbsent(int key, V value) { throw new UnsupportedOperationException(); }
        @Override public V remove(int key) { throw new UnsupportedOperationException(); }
        @Override public boolean remove(int key, Object value) { throw new UnsupportedOperationException(); }
        @Override public V replace(int key, V value) { throw new UnsupportedOperationException(); }
        @Override public boolean replace(int key, V oldValue, V newValue) { throw new UnsupportedOperationException(); }
        @Override public void replaceAll(IntBiFunction<? super V,? extends V> f) { throw new UnsupportedOperationException(); }
    }

    static class IntMap1<V> extends ImmutabbleIntMap<V> {
        private final int k0;
        private final V v0;

        IntMap1(int k0, V v0) {
            this.k0 = k0;
            this.v0 = Objects.requireNonNull(v0);
        }

        @Override
        public Set<IntMap.Entry<V>> entrySet() {
            return Set.of(IntMap.entry(k0, v0));
        }

        @Override
        public boolean containsKey(int o) {
            return o == k0; // implicit nullcheck of o
        }

        @Override
        public boolean containsValue(Object o) {
            return o.equals(v0); // implicit nullcheck of o
        }

        @Override
        public int hashCode() {
            return k0 ^ v0.hashCode();
        }
    }

    private static class EmptyIntMap<V> extends ImmutabbleIntMap<V> {
        public static final long serialVersionUID = -5514480375351672864L;

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public boolean containsKey(int key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public V get(int key) {
            return null;
        }

        @Override
        public IntSet keySet() {
            return EMPTY_INT_SET;
        }

        @Override
        public Collection<V> values() {
            return Collections.emptySet();
        }

        @Override
        public Set<IntMap.Entry<V>> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof IntMap) && ((IntMap) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_MAP;
        }
    }

    private static class EmptyLongMap<T> extends AbstractLongMap<T> implements Serializable {

        private static final long serialVersionUID = -7578467527233523710L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public boolean containsKey(long key)
        {
            return false;
        }

        @Override
        public boolean containsValue(Object value)
        {
            return false;
        }

        @Override
        public T get(long key)
        {
            return null;
        }

        @Override
        public LongSet keySet()
        {
            return EMPTY_LONG_SET;
        }

        @Override
        public Collection<T> values()
        {
            return Collections.emptySet();
        }

        @Override
        public Set<Entry<T>> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof LongMap) && ((LongMap) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_LONG_OBJECT_MAP;
        }
    }

    private static class EmptyIntIntMap extends AbstractIntIntMap implements  Serializable {
        public static final long serialVersionUID = 2323155007002525853L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public boolean containsKey(int key)
        {
            return false;
        }

        @Override
        public boolean containsValue(int value)
        {
            return false;
        }

        @Override
        public int get(int key)
        {
            return Constants.DEFAULT_INT_VALUE;
        }

        @Override
        public IntSet keySet()
        {
            return EMPTY_INT_SET;
        }

        @Override
        public IntCollection values()
        {
            return EMPTY_INT_LIST;
        }

        @Override
        public Set<Entry> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof IntIntMap) && ((IntIntMap) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_INT_MAP;
        }
    }

    private static class EmptyIntLongMap extends AbstractIntLongMap implements Serializable {

        public static final long serialVersionUID = 2323155007002525853L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public boolean containsKey(int key)
        {
            return false;
        }

        @Override
        public boolean containsValue(long value)
        {
            return false;
        }

        @Override
        public long get(int key)
        {
            return Constants.DEFAULT_LONG_VALUE;
        }

        @Override
        public IntSet keySet()
        {
            return EMPTY_INT_SET;
        }

        @Override
        public LongCollection values()
        {
            return EMPTY_LONG_LIST;
        }

        @Override
        public Set<IntLong> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof IntLongMap) && ((IntLongMap) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_LONG_MAP;
        }
    }

    private static class EmptyMapToLong<K> extends AbstractMapToLong<K> implements Serializable
    {

        public static final long serialVersionUID = 2323155007002525853L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public boolean containsKey(Object key)
        {
            return false;
        }

        @Override
        public boolean containsValue(long value)
        {
            return false;
        }

        @Override
        public long get(Object key)
        {
            return Constants.DEFAULT_LONG_VALUE;
        }

        @Override
        public Set<K> keySet()
        {
            return Collections.emptySet();
        }

        @Override
        public LongCollection values()
        {
            return EMPTY_LONG_LIST;
        }

        @Override
        public Set<Entry<K>> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof MapToLong) && ((MapToLong) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_MAP_TO_LONG;
        }
    }

    private static abstract class ImmutabbleMapToLong<K> extends AbstractMapToLong<K> implements Serializable{
        @Override public void clear() { throw new UnsupportedOperationException(); }
        @Override public long compute(K key, ToLongObjLongBiFunction<? super K> remappingFunction) { throw new UnsupportedOperationException(); }
        @Override public long computeIfAbsent(K key, ToLongFunction<? super K> mappingFunction) { throw new UnsupportedOperationException(); }
        @Override public long computeIfPresent(K key, ToLongObjLongBiFunction<? super K> remappingFunction) { throw new UnsupportedOperationException(); }
        @Override public long merge(K key, long value, LongToLongBiFunction remappingFunction) { throw new UnsupportedOperationException(); }
        @Override public long put(K key, long value) { throw new UnsupportedOperationException(); }
        @Override public void putAll(MapToLong<? extends K> m) { throw new UnsupportedOperationException(); }
        @Override public long putIfAbsent(K key, long value) { throw new UnsupportedOperationException(); }
        @Override public long remove(K key) { throw new UnsupportedOperationException(); }
        @Override public boolean remove(K key, long value) { throw new UnsupportedOperationException(); }
        @Override public long replace(K key, long value) { throw new UnsupportedOperationException(); }
        @Override public boolean replace(K key, long oldValue, long newValue) { throw new UnsupportedOperationException(); }
        @Override public void replaceAll(ToLongObjLongBiFunction<? super K> function) { throw new UnsupportedOperationException(); }
    }

    static class MapToLong1<K> extends ImmutabbleMapToLong<K> {
        private final K k0;
        private final long v0;

        MapToLong1(K k0, long v0) {
            this.k0 = Objects.requireNonNull(k0);
            this.v0 = v0;
        }

        @Override
        public Set<MapToLong.Entry<K>> entrySet() {
            return Set.of(MapToLong.entry(k0, v0));
        }

        @Override
        public boolean containsKey(Object o) {
            return o == k0; // implicit nullcheck of o
        }

        @Override
        public boolean containsValue(long o) {
            return o == v0;
        }

        @Override
        public int hashCode() {
            return k0.hashCode() ^ Long.hashCode(v0);
        }
    }

    private static class EmptyContainer implements Container
    {
        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public void clear()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isEmpty()
        {
            return false;
        }
    }

    private static class EmptyIntSet extends AbstractIntSet implements Serializable
    {
        public static final long serialVersionUID = 8067917265294829951L;

        @Override
        public PrimitiveIterator.OfInt iterator()
        {
            return EMPTY_INT_ITERATOR;
        }

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean contains(int obj)
        {
            return false;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_SET;
        }
    }

    private static class EmptyLongSet extends AbstractLongSet implements Serializable
    {
        public static final long serialVersionUID = 8067917265294829951L;

        @Override
        public LongIterator iterator()
        {
            return EMPTY_LONG_ITERATOR;
        }

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean contains(long obj)
        {
            return false;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_LONG_SET;
        }
    }


    private static class EmptyIntList extends AbstractIntList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = 7062789284942705902L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean contains(int obj)
        {
            return false;
        }

        @Override
        public int get(int index)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_LIST;
        }
    }

    private static class EmptyLongList extends AbstractLongList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = 8054308266104274168L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean contains(long obj)
        {
            return false;
        }

        @Override
        public long get(int index)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_LIST;
        }
    }

    private static class EmptyIntDoubleMap extends AbstractIntDoubleMap implements  Serializable {
        public static final long serialVersionUID = 2323155007002525853L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public boolean containsKey(int key)
        {
            return false;
        }

        @Override
        public boolean containsValue(double value)
        {
            return false;
        }

        @Override
        public double get(int key) {
            return Constants.DEFAULT_DOUBLE_VALUE;
        }

        @Override
        public IntSet keySet()
        {
            return EMPTY_INT_SET;
        }

        @Override
        public DoubleCollection values()
        {
            return EMPTY_DOUBLE_LIST;
        }

        @Override
        public Set<IntDouble> entrySet()
        {
            return Collections.emptySet();
        }

        @Override
        public boolean equals(Object o)
        {
            return (o instanceof IntIntMap) && ((IntIntMap) o).size() == 0;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_INT_MAP;
        }
    }

    private static class EmptyDoubleList extends AbstractDoubleList implements RandomAccess, Serializable
    {
        public static final long serialVersionUID = 7062789284942705902L;

        @Override
        public int size()
        {
            return 0;
        }

        @Override
        public boolean contains(double obj)
        {
            return false;
        }

        @Override
        public double get(int index)
        {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        // Preserves singleton property
        private Object readResolve()
        {
            return EMPTY_INT_LIST;
        }
    }
}
