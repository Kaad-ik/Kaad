package hu.elte.recipe.services;

import java.util.LinkedList;
import java.util.List;

import org.mockito.internal.listeners.CollectCreatedMocks;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

// TODO: Auto-generated Javadoc
/**
 * The Class MocksCollector.
 */
public class MocksCollector {
    
    /** The created mocks. */
    private final List<Object> createdMocks;

    /**
     * Instantiates a new mocks collector.
     */
    public MocksCollector() {
        createdMocks = new LinkedList<Object>();
        final MockingProgress progress = new ThreadSafeMockingProgress();
        progress.setListener(new CollectCreatedMocks(createdMocks));
    }

    /**
     * Gets the mocks.
     *
     * @return the mocks
     */
    public Object[] getMocks() {
        return createdMocks.toArray();
    }
}