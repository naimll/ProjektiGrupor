create database LibraryManagmentSystem
use LibraryManagmentSystem

create table Stafi(
Stafi_Id int primary key,
S_Emri varchar(40) not null,
S_Mbiemri varchar(50) not null,
S_Tel varchar(30) not null,
S_User varchar(40) not null,
S_Password varchar(50) not null,
)

create table Klienti(
K_Id int primary key,
K_Emri varchar(50) not null,
K_Mbiemri varchar(50) not null,
K_Mosha int not null,
K_Gjinia varchar(50) not null,
K_Data_Lindjes date,
K_Tel varchar(30) not null,
K_Shteti varchar(50) not null,
K_Email varchar(100) not null,
K_User varchar(50) not null,
K_Password varchar(50) not null
)

create table Autori(
A_Id int primary key,
A_Emri varchar(50) not null,
A_Mbiemri varchar(50) not null,
A_Vendlindja varchar(50) not null,
)
Create table Kategoria_Librit(
Kategoria_Id int primary key,
KL_Emri varchar(50) not null,
KL_Sasia varchar(50) not null,
)
create table Libri_Autoret(
ISBN varchar(100),
A_Id int,
foreign key(ISBN) references Libri(ISBN),
foreign key(A_Id) references Autori(A_Id),
unique(ISBN,A_Id)
)
 
create table Libri(
ISBN varchar(100) primary key,
L_Titulli varchar(255) not null,
L_Viti_Botimit int not null,
L_Shtepia_Botuese varchar(100) not null,
L_Sasia int not null,
L_Stafi_Id int,
L_Kategoria_Id int,
foreign key(L_Stafi_Id) references Stafi(Stafi_Id),
foreign key(L_Kategoria_Id) references Kategoria_Librit(Kategoria_Id)
)
create table Huazimi_Librit(
HL_Id int primary key,
HL_Data_Leshimit date not null,
HL_Afati_Kthimit date not null,
HL_Klienti_Id int,
HL_ISBN varchar(100),
foreign key(HL_Klienti_Id) references Klienti(K_Id),
foreign key(HL_ISBN) references Libri(ISBN)
)
create table Kthimi_Librit(
KthL_Id int primary key,
KthL_Data_Leshuar date,
KthL_Data_Kthyer date,
KthL_Klienti_Id int,
KthL_ISBN varchar(100)
foreign key(KthL_Klienti_Id) references Klienti(K_ID),
foreign key(KthL_ISBN) references Libri(ISBN)
)
