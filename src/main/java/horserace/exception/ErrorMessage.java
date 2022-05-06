package horserace.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class ErrorMessage {
    @JsonProperty("title")
    private String title;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("details")
    private String details;

    public ErrorMessage(String title, Integer statusCode, String details) {
        this.title = title;
        this.statusCode = statusCode;
        this.details = details;
    }

    public ErrorMessage() {
    }

    @Override
    public String toString() {

        return "class ErrorMessage {\n" +
                "    title: " + title + "\n" +
                "    statusCode: " + statusCode + "\n" +
                "    detail: " + details + "\n" +
                "}";
    }
}
