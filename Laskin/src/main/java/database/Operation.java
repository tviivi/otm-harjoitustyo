package database;

public class Operation {
    private Integer id;
    private String operation;

    public Operation(String operation) {
        this.operation = operation;
    }

    public Integer getId() {
        return id;
    }

    public String getOperation() {
        return operation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
