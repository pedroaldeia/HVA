package hva.search;

import hva.Hotel;
import hva.exceptions.CoreException;

public interface SearchStrategy{
    public String search(Hotel hotel, String id) throws CoreException;
}
