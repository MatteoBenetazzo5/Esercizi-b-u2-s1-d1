package matteobenetazzo.esercizibu2s1d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Table {
    private int number;
    private int maxCovers;
    private TableStatus status;
}
