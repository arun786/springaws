# Basics of JPQL


## To find a particular Customer, input is an Id.

    Steps:
        1. AutoWire EntityManager
        2. Use EntityManager find method to get particular details of Customer with the Id.
       
       
        @Autowired
        EntityManager entityManager;
    
        @Override
        public Customer findById(Integer id) {
            return entityManager.find(Customer.class, id);
        }
        

## To delete a Customer with an Id

    Steps:
        1. The class has to be annotated with @Transactional
        2. find the Customer based on Id
        3. use EntityManager remove method to delete the customer 
    
        @Override
        public void deleteById(Integer id) {
            Customer customer = entityManager.find(Customer.class, id);
            entityManager.remove(customer);
        }
        
## To insert or save a customer


         Steps:
                1. The class has to be annotated with @Transactional
                2. if the id of the customer is null, insert the details using entitymanger persist function
                3. if the id of the Customer is present, update using entityManager merge function.
                
        @Override
        public Customer save(Customer customer) {
        
            /**
             * Insert
             */
            if (customer.getId() == null) {
                entityManager.persist(customer);
            } else {
                /*
                update
                 */
                customer = entityManager.merge(customer);
            }
            return customer;
        }