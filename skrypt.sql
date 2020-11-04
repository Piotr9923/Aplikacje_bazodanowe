CREATE TABLE `Czytelnicy` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `imie` varchar(255),
  `nazwisko` varchar(255),
  `id_adresu` int,
  `nr_telefonu` varchar(255),
  `rok_urodzenia` varchar(255)
);

CREATE TABLE `Ksiazki_do_wypozyczenia` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `tytul` varchar(255),
  `autor` varchar(255),
  `gatunek` varchar(255),
  `dostepna` boolean
);

CREATE TABLE `Wypozyczenia` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_czytelnika` int,
  `id_ksiazki` int,
  `data_wypozyczenia` date,
  `data_zwrotu` date
);

CREATE TABLE `Adresy` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `kod` varchar(255),
  `miejscowosc` varchar(255),
  `ulica` varchar(255),
  `nr_domu` int
);

ALTER TABLE `Wypozyczenia` ADD FOREIGN KEY (`id_ksiazki`) REFERENCES `Ksiazki_do_wypozyczenia` (`id`);

ALTER TABLE `Wypozyczenia` ADD FOREIGN KEY (`id_czytelnika`) REFERENCES `Czytelnicy` (`id`);

ALTER TABLE `Czytelnicy` ADD FOREIGN KEY (`id_adresu`) REFERENCES `Adresy` (`id`);
