package com.examples.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyTest
{
	@Mock
	private List<String> strings;
	
	@Test
	public void test()
	{
		List<Integer> list = mock(List.class);
		when(list.get(0)).thenReturn(10);
		when(strings.get(0)).thenReturn("hi");
		assertEquals(Integer.valueOf(10), list.get(0));
		assertEquals("hi", strings.get(0));
	}
}
