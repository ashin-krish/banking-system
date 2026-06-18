package persistence;

import model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CustomerFileHandler 
{
    

    public List<Customer> loadCustomer()
    {
        List<Customer> customers = new ArrayList<>();

          File f = new File("data/Customer_data.txt");

          if(!f.exists())
          {
            return customers;
          }

          try(BufferedReader br = new BufferedReader(new FileReader(f))) 
          {

            br.readLine();

            String line;
            
            while((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if(data.length == 6)
                {
                    String name = data[0];
                    String email = data[1];
                    String phone = data[2];
                    String address = data[3];
                    String dob = data[4];
                    String customerId = data[5];

                    Customer customer = new Customer(name, email, phone, address, dob, customerId);

                    customers.add(customer);
                }
                else
                {
                           System.out.println("Invalid Record" + line);
                           continue;
                }
            }

            return customers;

            
          } 
          catch (IOException e) 
          {
            System.out.println(e);
          }

         

          return customers;
    }


    public void saveFile(List<Customer> customers)
    throws IOException
    {
        File f = new File("data/Customer_data.txt");

        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)
                )
                {
                        bw.write("name,email,phoneNumber,address,dob,customerId");
                        bw.newLine();

                        for (Customer existingCustomer : customers) {
                            bw.write(existingCustomer.getName() + "," +
                                    existingCustomer.getEmail() + "," + 
                                    existingCustomer.getPhoneNumber() + "," + 
                                    existingCustomer.getAddress() + "," +
                                    existingCustomer.getDOB() + "," +
                                    existingCustomer.getCustomerId());  
                            bw.newLine();
                        }
                }
    }
}
