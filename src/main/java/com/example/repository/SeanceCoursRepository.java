/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

//import com.example.entity.Jour;
import com.example.entity.Jour;
import com.example.entity.SeanceCours;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yacin
 */
@Repository
public interface SeanceCoursRepository extends JpaRepository<SeanceCours,Long> {
    
    public List<SeanceCours> findBynomCours(String nomCours);
    public List<SeanceCours> findByjour(Jour jour);
    //public List<SeanceCours> findById(Long id);

    //public Object findBynomjour(String mc);

   
}
