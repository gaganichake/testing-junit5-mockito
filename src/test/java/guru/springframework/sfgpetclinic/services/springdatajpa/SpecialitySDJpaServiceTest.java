package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    // Create a new instance of SpecialitySDJpaService using the constructor and
    // inject the Mock (of SpecialtyRepository) into the constructor for us
    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void delete() {
        specialitySDJpaService.delete(new Speciality());
    }

    @Test
    void deleteById() {
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called with value 1L
        verify(specialtyRepository).deleteById(1L);
    }

    @Test
    void deleteByIdTimes() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called exactly 2 time with value 1L
        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeastOnce() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called at least once with value 1L
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeast() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called at least 1 time with value 1L
        verify(specialtyRepository, atLeast(1)).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called at most 5 time with value 1L
        verify(specialtyRepository, atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        specialitySDJpaService.deleteById(1L);
        specialitySDJpaService.deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was called at most 5 time with value 1L
        verify(specialtyRepository, atMost(5)).deleteById(1L);

        // Verify that during this test specialtyRepository.deleteById() was never called with value 5L
        verify(specialtyRepository, never()).deleteById(5L);
    }

    @Test
    void findById() {

        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(new Speciality()));

        Speciality speciality = specialitySDJpaService.findById(1L);

        assertThat(speciality).isNotNull();

        verify(specialtyRepository).findById(1L);
    }

    @Test
    void testDelete() {

        specialitySDJpaService.delete(new Speciality());

        // Using Argument Matchers.
        // In case we not want to verify against a specific value but just the type
        verify(specialtyRepository).delete(any(Speciality.class));
    }
}