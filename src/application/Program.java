package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("==== TEST 2: Seller findByDepartment ====");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("==== TEST 3: Seller findAll ====");
        dep = new Department(2, null);
        list = sellerDao.findAll();
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("==== TEST 4: Seller insert ====");
        Seller newSeller = new Seller(null, "Walter Grey",
                "walter@gmail.com", new Date(), 3000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("==== TEST 5: Seller update ====");
        String previousName = newSeller.getName();
        newSeller.setName("Alice Crow");
        sellerDao.update(newSeller);
        System.out.println("Previous name " + previousName + " updated! New name: "
                + sellerDao.findById(newSeller.getId()).getName());

        System.out.println("==== TEST 6: Seller delete ====");
        sellerDao.deleteById(newSeller.getId());
        System.out.println("Delete completed! ");

        System.out.println("==== TEST 7: Department findById ====");
        dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("==== TEST 8: Department findAll ====");
        List<Department> dep_list = departmentDao.findAll();
        for (Department obj: dep_list){
            System.out.println(obj);
        }

        System.out.println("==== TEST 9: Department insert ====");
        Department newDep = new Department(null, "Temporary");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());

        System.out.println("==== TEST 10: Department update ====");
        previousName = newDep.getName();
        newDep.setName("Grocery");
        departmentDao.update(newDep);
        System.out.println("Previous name " + previousName + " updated! New name: "
                + departmentDao.findById(newDep.getId()).getName());

        System.out.println("==== TEST 11: Department delete ====");
        departmentDao.deleteById(newDep.getId());
        System.out.println("Delete completed!");
    }
}
