package com.sys.billing.models;

import com.sys.billing.utils.CartItem;
import com.sys.billing.utils.Payment_Mode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Bill {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private UUID billId;
//    @OneToMany
//    private List<CartItem> items = new ArrayList<CartItem>();

//    @ManyToOne
    private int customerId;
    private int totalPrice;
    private Payment_Mode paymentMode;
}
