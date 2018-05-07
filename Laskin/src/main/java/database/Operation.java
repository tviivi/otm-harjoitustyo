package database;

/**
 * A class for the calculation operations
 */
public class Operation {
    private Integer id;
    private String operation;

    public Operation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the id of the operation
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the operation itself
     * @return operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets an id
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets an operation
     * @param operation 
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}