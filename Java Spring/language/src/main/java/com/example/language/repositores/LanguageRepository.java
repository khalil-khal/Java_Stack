package com.example.language.repositores;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.language.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository<Languages, Long> {
List<Languages> findAll();
}
