package com.sys.billing.models;

import com.sys.billing.utils.Payment_Mode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Bill implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID billId;

    @NotEmpty(message = "Should contains min 1 item to make a bill")
    @ElementCollection
    private List<Cart> cartItems;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private float totalPrice;

    private Payment_Mode paymentMode;
    
    private LocalDateTime dateTime;
}
