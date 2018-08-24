package app.springbootdemo.database.dbmodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class Ill extends TimeTable {


}