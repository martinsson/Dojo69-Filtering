package org.cara.dojo.dojo69;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.cara.dojo.dojo69.adapter.plexus.PlexusFilter;
import org.cara.dojo.dojo69.application.Arguments;
import org.cara.dojo.dojo69.application.Filtering;
import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;


public class FilteringTest {

	@Test
	public void filter_Should_GenerateFilteredFile_WithExpectedKey()
			throws Exception {
		// Given
		Filtering filtering = new Filtering(new PlexusFilter());
		
		String fileToProcess = "target/test-classes/config.properties";
		String fileProcessed = "target/test-classes/config-filtered.properties";
		
		List<String> filterFiles = new ArrayList<String>();
		filterFiles.add("target/test-classes/filter1.properties");
		filterFiles.add("target/test-classes/filter2.properties");

		Arguments arguments = Mockito.mock(Arguments.class);
		Mockito.when(arguments.getFileToProcess()).thenReturn(fileToProcess);
		Mockito.when(arguments.getFileProcessed()).thenReturn(fileProcessed);
		Mockito.when(arguments.getFilterFiles()).thenReturn(filterFiles);
		
		// When
		filtering.filter(arguments);
		
		// Then
		File expectedFileProcessed = new File("target/test-classes/FilteringTest.filter_Should_GenerateFilteredFile_WithExpectedKey.approved.txt");
		File actualFileProcessed = new File(fileProcessed);
		Assertions.assertThat(actualFileProcessed).hasContentEqualTo(expectedFileProcessed);
	}
}
