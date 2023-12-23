package ru.pyrinoff.somebotexamples.example1.customization.model;


import com.github.pyrinoff.somebot.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
//@MappedSuperclass
@Entity
@Table(name = "users", schema = "public")
@Accessors(chain = true)
public class CustomUser extends User {

    private static final long serialVersionUID = 1;

    @Override
    public String toString() {
        return "CustomUser{" +
                "chatId=" + chatId +
                ", registered=" + registered +
                ", locked=" + locked +
                '}';
    }

}