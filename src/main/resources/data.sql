-- file utilizzato per popolare con dati di esempio o default la nostra base ati
--

insert into persona(id, nome,cognome)
values(1, "Mario", "Red"),
(2, "Michele", "Bossi"),
(3, "Michela", "Manelli"),
(4, "Gino", "Brunetta"),
(5, "Maria", "Vongola"),
(6, "Gina", "Branzino");

-- il next val è intra tabelle, pertanto è un valore alto che non verrà raggiunto con l'import automatico
-- update hibernate_sequence set next_val=1000;
-- insert into merendine values (id, marca, nome, prezzo) values


