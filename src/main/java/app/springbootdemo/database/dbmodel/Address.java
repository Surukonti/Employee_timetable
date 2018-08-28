package app.springbootdemo.database.dbmodel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



    @Entity
    @Table(name = "Address")
    public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private long id;

        @Column
        @NotBlank
        private long postcode;

        @Column
        @NotBlank
        private String street;

        @Column
        @NotBlank
        private String type;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "emp_id", nullable = false)
        private Employee employee;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getPostcode() {
            return postcode;
        }

        public void setPostcode(long postcode) {
            this.postcode = postcode;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public Address() {
            this.postcode = postcode;
            this.street = street;
            this.type = type;
            this.employee = employee;
        }
    }
