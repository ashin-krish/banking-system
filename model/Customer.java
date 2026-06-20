package model;

public class Customer 

{
    private String name;
    private String email;
    private String  phone;
    private String address;
    private String dob;
    private String customerId;

    private static int counter = 1000;


    public Customer(String name,String email,String phone,String address, String dob)
    {
           setAddress(address);
           setEmail(email);
           setName(name);
           setPhoneNumber(phone);
           setDob(dob);
        
           this.customerId = generateCustomerId();
    }

 
    private String generateCustomerId()
    {
          return "CUS" + counter++;
    }


    public String getCustomerId()
    {
       return customerId;
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Name Cannot Be Empty");
        }

        this.name = name.trim();
    }


       public void setAddress(String address)
    {
        if(address == null || address.trim().isEmpty())
        {
            throw new IllegalArgumentException("Address Cannot Be Empty");
        }

        this.address = address.trim();
    }


  public void  setEmail(String email) 
{
  String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

   if(email == null || !email.trim().matches(EMAIL_REGEX))
   {
      throw new IllegalArgumentException("Invalid Email Format");
   }
this.email = email.trim();

}

public void setPhoneNumber(String phone) 
{
    if (phone == null || !phone.matches("\\d{10}")) {
        throw new IllegalArgumentException("Enter valid 10-digit phone number");
    }
    this.phone = phone;
}


    public void setDob(String dob)
{
    String regex = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$";

    if(dob == null || dob.isEmpty())
     {
           throw new IllegalArgumentException(" DOB cannot be Blank ");
     }

    if(!dob.matches(regex))
    {
        throw new IllegalArgumentException("Invalid DOB format (dd-mm-yyyy)");
    }
  this.dob = dob;
}




public String getCustomerName()
{
  return name;
}

public String getEmail()
{
  return email;
}

public String getPhoneNumber()
{
  return phone;
}


public String getAddress()
{
  return address;
}

public String getDOB()
{
  return dob;
}

public String getName()
{
  return name;
}


@Override
public String toString() {
    return "Customer{" +
            "customerId='" + customerId + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", dob='" + dob + '\'' +
            '}';
}


}
