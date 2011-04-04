package com.twolighters.slim.util;

import java.util.Arrays;

public class ArrayUtil
{
	/**
	 * Concatenate any number of arrays.
	 * 
	 * Source:
	 * http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java
	 * 
	 * @param <T>
	 * @param first
	 * @param rest
	 * @return
	 */
	public static <T> T[] concatAll(T[] first, T[]... rest)
	{
		int totalLength = first.length;
		for (T[] array : rest)
		{
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest)
		{
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
}
