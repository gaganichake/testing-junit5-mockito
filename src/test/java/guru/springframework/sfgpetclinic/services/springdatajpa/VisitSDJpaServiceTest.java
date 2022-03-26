package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService visitSDJpaService;

    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> returnedVisits = visitSDJpaService.findAll();

        //assertThat(returnedVisits).isNotNull();// findAll method already has a new HashSet created
        assertThat(returnedVisits).hasSize(1);

        verify(visitRepository).findAll();
    }

    @Test
    void findById() {

        when(visitRepository.findById(1L)).thenReturn(Optional.of(new Visit()));

        Visit returnedVisit = visitSDJpaService.findById(1L);

        assertThat(returnedVisit).isNotNull();

        verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {

        when(visitRepository.save(any(Visit.class))).thenReturn(new Visit());

        Visit returnedVisit = visitSDJpaService.save(new Visit());

        assertThat(returnedVisit).isNotNull();

        verify(visitRepository).save(any(Visit.class));
    }

    @Test
    void delete() {
        visitSDJpaService.delete(new Visit());

        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        visitSDJpaService.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}