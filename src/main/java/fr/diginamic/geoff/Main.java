package fr.diginamic.geoff;

import fr.diginamic.geoff.builder.ClubDTOBuilder;
import fr.diginamic.geoff.builder.DTOBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("soccer");
                EntityManager em = emf.createEntityManager();){

            List<String> a = null;
            ClubDTOBuilder builder = new ClubDTOBuilder();

            builder.buildDTOList(a);

        }
    }
}