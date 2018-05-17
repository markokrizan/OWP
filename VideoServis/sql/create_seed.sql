DROP SCHEMA IF EXISTS videoServis;
CREATE SCHEMA videoServis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE videoServis;

#alt + enter - UTF8

#select * from korisnici;
#select * from klipovi;
#select * from komentari;
#select * from lajkovi;
#select * from prati;
#select * from korisnici_klipovi;
#select * from video_lajkovi;
#select * from komentar_lajkovi;

CREATE TABLE korisnici(
	id BIGINT AUTO_INCREMENT ,
	obrisan BIT NOT NULL,
	kor_ime VARCHAR(50) NOT NULL,
	lozinka VARCHAR(50) NOT NULL,
	ime VARCHAR(20),
	prezime VARCHAR(20),
	email VARCHAR(50) NOT NULL,
	opis VARCHAR(500),
	datum_registracije DATE,
	uloga ENUM('NEPRIJAVLJENI', 'KORISNIK', 'ADMINISTRATOR'),
	blokiran BIT,
	
	PRIMARY KEY(id)
);

#bar 3 obicna korisnika i bar 1 administratora
INSERT INTO korisnici(obrisan, kor_ime, lozinka, ime, prezime, email, opis, datum_registracije, uloga, blokiran)
VALUES (0, 'pekip', 'p123', 'Petar', 'Petrovic', 'peki123@gmail.com', 'Pekijev kanal', '2009-02-02', 'KORISNIK', 0);

INSERT INTO korisnici(obrisan, kor_ime, lozinka, ime, prezime, email, opis, datum_registracije, uloga, blokiran)
VALUES (0, 'mile', 'm789', 'Mile', 'Milenkovic', 'mile789@gmail.com', 'Miletov kanal', '2009-03-03', 'KORISNIK', 0);

INSERT INTO korisnici(obrisan, kor_ime, lozinka, ime, prezime, email, opis, datum_registracije, uloga, blokiran)
VALUES (0, 'levi', 'l321', 'Levi', 'Levat', 'levi321@gmail.com', 'Levijev kanal', '2009-04-04', 'KORISNIK', 0);

INSERT INTO korisnici(obrisan, kor_ime, lozinka, ime, prezime, email, opis, datum_registracije, uloga, blokiran)
VALUES (0, 'savas', 's456', 'Sava', 'Savanovic', 'sava456@gmail.com', 'Savin kanal', '2009-01-01', 'ADMINISTRATOR', 0);

#korisnik 0,1 --------------prati---------------0,1 korisnik
CREATE TABLE prati(
	prati BIGINT,
    pracen BIGINT,
	FOREIGN KEY(prati) REFERENCES korisnici(id), 
    FOREIGN KEY(pracen) REFERENCES korisnici(id)
);


CREATE TABLE klipovi(
	id BIGINT AUTO_INCREMENT,
	obrisan BIT NOT NULL,
	url VARCHAR(150) NOT NULL,
	thumbnail VARCHAR(150) NOT NULL,
	opis VARCHAR(700) NOT NULL,
	vidljivost ENUM('JAVNI', 'UNLISTED', 'PRIVATNI'),
	dozvoljeni_komentari BIT NOT NULL,
	vidljivost_rejtinga BIT NOT NULL,
	blokiran BIT NOT NULL,
	broj_pregleda BIGINT,
	datum_kreiranja DATE,
	
	
	PRIMARY KEY(id)
);

#'YYYY-MM-DD'
#-bar 1 unlisted i 1 privatni video, a bar 5 javnih videa (od kojih
#-bar 3 videa imaju istog običnog korisnika za vlasnika) sa različitim podacima sa stanovišta pretrage
#-http://www.get-youtube-thumbnail.com/
INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=JANApS0P4z8', 'http://i3.ytimg.com/vi/JANApS0P4z8/hqdefault.jpg', 'Pls don''t take away my ads youtube think of my appendix.', 'JAVNI', 1, 1, 0, 15, '2017-12-25');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=tUE1_SBXWoQ', 'http://i3.ytimg.com/vi/tUE1_SBXWoQ/hqdefault.jpg', 'Dnevnjak - nasilje nad zenama', 'JAVNI', 1, 1, 0, 23, '2018-04-25');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=sV8IMKc-TlA', 'http://i3.ytimg.com/vi/sV8IMKc-TlA/hqdefault.jpg', 'Susret poznanika.', 'JAVNI', 1, 1, 0, 12, '2016-10-15');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=EUg7YyXflhE', 'http://i3.ytimg.com/vi/EUg7YyXflhE/hqdefault.jpg', 'External GPU enclosures.', 'JAVNI', 1, 1, 0, 33, '2018-01-19');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=SrU9YDoXE88', 'http://i3.ytimg.com/vi/SrU9YDoXE88/hqdefault.jpg', 'Count past infinity.', 'JAVNI', 1, 1, 0, 90, '2016-05-09');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=7uiv6tKtoKg', 'http://i3.ytimg.com/vi/7uiv6tKtoKg/hqdefault.jpg', 'What will we miss?', 'PRIVATNI', 1, 1, 0, 3, '2013-06-28');

INSERT INTO klipovi(obrisan, url, thumbnail, opis, vidljivost, dozvoljeni_komentari, vidljivost_rejtinga, blokiran, broj_pregleda, datum_kreiranja)
VALUES(0, 'https://www.youtube.com/watch?v=9PZoe-JW5Lw', 'http://i3.ytimg.com/vi/9PZoe-JW5Lw/hqdefault.jpg', 'Used MacBook Air', 'UNLISTED', 1, 1, 0, 30, '2018-04-17');


#veza korisnika i klipova

CREATE TABLE korisnici_klipovi(
	korisnik_id BIGINT,
    video_id BIGINT,
	FOREIGN KEY(korisnik_id) REFERENCES korisnici(id), 
    FOREIGN KEY(video_id) REFERENCES klipovi(id)
);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(1, 1);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(1, 2);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(1, 3);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(2, 4);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(2, 5);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(3, 6);

INSERT INTO korisnici_klipovi(korisnik_id, video_id)
VALUES(3, 7);


CREATE TABLE komentari(
	id BIGINT AUTO_INCREMENT,
	obrisan BIT NOT NULL,
	sadrzaj VARCHAR(500),
	datum_kreiranja DATE,
	#mora imati vlasnika, veza sa ove strane
	id_korisnika BIGINT,
    id_videa BIGINT,
	FOREIGN KEY(id_korisnika) REFERENCES korisnici(id),
	FOREIGN KEY(id_videa) REFERENCES klipovi(id),
	
	PRIMARY KEY(id)
);

INSERT INTO komentari(obrisan, sadrzaj, datum_kreiranja, id_korisnika, id_videa)
VALUES(0, 'Video nista ne valja!', '2018-04-22', 3, 1);

INSERT INTO komentari(obrisan, sadrzaj, datum_kreiranja, id_korisnika, id_videa)
VALUES(0, 'Moze to i bolje!', '2018-04-23', 3, 1);

INSERT INTO komentari(obrisan, sadrzaj, datum_kreiranja, id_korisnika, id_videa)
VALUES(0, 'Svaka cast!', '2018-04-24', 2, 1);



CREATE TABLE lajkovi(
	id BIGINT AUTO_INCREMENT,
	lajk BIT NOT NULL,
	datum_kreiranja DATE,
	
	PRIMARY KEY(id)
	

);

# - 0 dislajk, 1 lajk
INSERT INTO lajkovi(lajk, datum_kreiranja)
VALUES (0, '2018-04-22');

INSERT INTO lajkovi(lajk, datum_kreiranja)
VALUES (0, '2018-04-23');

INSERT INTO lajkovi(lajk, datum_kreiranja)
VALUES (1, '2018-04-24');

INSERT INTO lajkovi(lajk, datum_kreiranja)
VALUES (1, '2018-04-24');

# - veza komenatara i videa sa lajkovima:

CREATE TABLE video_lajkovi(
	video_id BIGINT,
    lajk_id BIGINT,
	FOREIGN KEY(video_id) REFERENCES klipovi(id), 
    FOREIGN KEY(lajk_id) REFERENCES lajkovi(id)
);

INSERT INTO video_lajkovi(video_id, lajk_id)
VALUES(1, 1);

INSERT INTO video_lajkovi(video_id, lajk_id)
VALUES(1, 2);

INSERT INTO video_lajkovi(video_id, lajk_id)
VALUES(1, 3);

CREATE TABLE komentar_lajkovi(
	komentar_id BIGINT,
    lajk_id BIGINT,
	FOREIGN KEY(komentar_id) REFERENCES komentari(id), 
    FOREIGN KEY(lajk_id) REFERENCES lajkovi(id)
);

INSERT INTO komentar_lajkovi(komentar_id, lajk_id)
VALUES(3, 4);

