package com.example.demo.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message="is required")
    @Column(name="item_name")
    private String itemName;
    @NotBlank(message="is required")
    @Column(name="item_quantity")
    private Integer itemQuantity;
    @NotBlank(message="is required")
    private Double itemPrice;
}
