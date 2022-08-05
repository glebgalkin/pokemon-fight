package pokemon.application.model;


import java.util.List;

public class PokemonListResponse {

    private int count;
    private String next;
    private String previous;
    private List<Result> results;

    public PokemonListResponse(){}

    public PokemonListResponse(int count, String next, String previous, List<Result> result) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public  List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> result) {
        this.results = result;
    }
}
