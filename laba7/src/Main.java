class Customer {
    String lastName;
    String firstName;
    String middleName;
    String address;
    String phone;
    String creditCardNumber;
    String bankAccountNumber;

    public Customer(String lastName, String firstName, String middleName, String address, String phone, String creditCardNumber, String bankAccountNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }
}

public class Main {
    public static void main(String[] args) {

        Customer[] customers = {
                new Customer("Иванов", "Иван", "Иванович", "ул. Пушкина, д.1", "1234567890", "1111122233334444", "1234567890123456"),
                new Customer("Петров", "Петр", "Петрович", "ул. Лермонтова, д.2", "0987654321", "5555666677778888", "6543210987654321"),
                new Customer("Сидоров", "Сидор", "Сидорович", "ул. Гоголя, д.3", "5678901234", "1111222233334444", "9876543210987654")
        };

        String creditCardNumberSearch = "1111222233334444";


        for (Customer customer : customers) {
            if (customer.creditCardNumber == creditCardNumberSearch) {
                System.out.println(customer.lastName + " " + customer.firstName + " " + customer.middleName + " имеет искомый номер кредитной карты");
            }
        }
    }
}
