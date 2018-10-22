package app.springbootdemo.database.dbmodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Illl")
public class Ill extends TimeTable {


}