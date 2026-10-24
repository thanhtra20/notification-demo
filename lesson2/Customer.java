package lesson2;

public class Customer {

    private final int id;
    private final String name;
    private final Address address;

    public Customer(int id, String name,Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

     public Address getAddress() {
        return address;
    }

     @Override
     public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
     }

     @Override
     public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
     }

    
   

   

}
