package tn.esprit.pokerplanning.Entities;

public class DialogflowResponse {
    private String message;
    public DialogflowResponse(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DialogflowResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
