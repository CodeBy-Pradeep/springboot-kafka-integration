package com.example.kafka_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/*Lombok’s @Data is a convenience annotation that combines several others:

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
---------------------------------------
So it automatically generates:
    Getters for all fields
    Setters for all non-final fields
    equals() and hashCode()
    toString()
    A required-args constructor
*/

@Data
//@ToString(exclude = "quantity") // Exclude quantity from toString() method
public class Order {
    // Map JSON property "id" to field "orderId" , if the JSON has "id" field instead of "orderId" .
    // pass id in json to map to orderId from postman
    @JsonProperty("id")
    private String orderId;
    private String product;
    private int quantity;


    //💡 Lombok detects that you’ve written your own toString(),
    //so it will not generate its own — your version takes precedence.
/*    @Override
    public String toString() {
        return orderId + " - " + product + " - " + quantity;
    }*/

}
