Create database JeeArticle;
use JeeArticle;

Create table Article(idArticle int primary key, nomArticle varchar(20), DescriptionArticle varchar(30), EtatArticle varchar(12));

insert into Article values(1, 'Test', 'TestDesc', 'TestEtat'); 

Select * from Article;