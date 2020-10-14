import java.util.InputMismatchException;
import java.util.Scanner;
import data.PersonData;
import entities.Person;

public class Main {

    public static void main(String[] args) {

        PersonData data = new PersonData();
        Scanner input = new Scanner(System.in);
        int opt = 0;
        
        do {
            System.out.println("***** CRUD PERSON *****");
            System.out.println("1 List ");
            System.out.println("2 New ");
            System.out.println("3 Delete ");
            System.out.println("4 Get byID ");
            System.out.println("5 Update ");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); // Limpiar el buffer
            switch (opt) {
                case 1:
                    System.out.println("Listado de personas ");
                    for (Person d : data.list("")) {
                        System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getSex() + "\t" + d.getAge() + "\t" + d.getNationality());
                    }
                    break;
                case 2:
                    System.out.println("Nueva persona ");
                    Person p = new Person();
                    System.out.print("nombre: ");
                    p.setName(input.nextLine());
                    System.out.print("sexo: ");
                    p.setSex(input.nextLine());
                    System.out.print("nacionalidad: ");
                    p.setNationality(input.nextLine());

                    System.out.print("edad: ");
                    try {
                        p.setAge(input.nextInt());
                        data.create(p);
                    } catch (Exception e) {
                        input.nextLine(); // Limpiar el buffer
                        System.out.print("Edad debe ser entero, no se guardo");
                    }

                    break;
                case 3:
                    System.out.println("Eliminar persona ");
                    System.out.print("id: ");
                    data.delete(input.nextInt());
                    break;
                case 4:
                    int b4 = 1;
                    do {
                        System.out.println("get persona ");
                        System.out.print("id: ");
                        int id = 0;
                        try {
                            b4 = 0;
                            id = input.nextInt();
                            Person d = data.get(id);
                            if (d != null) {
                                System.out.println("Id: " + d.getId());
                                System.out.println("Name: " + d.getName());
                            } else {
                                System.out.print("la person no existe");
                            }
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("id no valido, debe ser un numero");
                            b4 = 1;
                        }

                    } while (b4 != 0);

                    break;
                case 5:
                    System.out.println("update persona ");
                    System.out.print("id: ");

                    Person per = data.get(input.nextInt());

                    if (per != null) {
                        System.out.println("Name current: " + per.getName());
                        System.out.println("Sex current: " + per.getSex());

                        input.nextLine(); // Limpiar el buffer
                        System.out.print("Nuevo Nombre: ");
                        per.setName(input.nextLine());

                        System.out.print("nuevo Sexo: ");
                        per.setSex(input.nextLine());

                        System.out.print("Nueva Nacionalidad: ");
                        per.setNationality(input.nextLine());

                        System.out.print("Nueva Edad: ");
                        try {
                            per.setAge(input.nextInt());
                            data.update(per);
                        } catch (Exception e) {
                            // per.setAge(0);
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("Edad debe ser entero, no se guardo");
                        }

                    } else {
                        System.out.println("NO encontrado");
                    }

                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opt != 0);
    }
}
