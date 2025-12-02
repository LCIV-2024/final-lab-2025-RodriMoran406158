package com.example.demobase.service;

import com.example.demobase.dto.WordDTO;
import com.example.demobase.model.Word;
import com.example.demobase.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WordServiceTest {

    @Mock
    private WordRepository wordRepository;

    @InjectMocks
    private WordService wordService;

    private Word word1;
    private Word word2;
    private Word word3;

    @BeforeEach
    void setUp() {
        word1 = new Word(1L, "PROGRAMADOR", true);
        word2 = new Word(2L, "COMPUTADORA", false);
        word3 = new Word(3L, "TECNOLOGIA", false);
    }

    @Test
    void testGetAllWords() {
        // TODO: Implementar el test para getAllWords
        //given
        List<Word> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);

        //when
        when(wordRepository.findAllOrdered()).thenReturn(words);

        //then
        List<WordDTO> result = wordService.getAllWords();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(words.contains(word1));
        assertTrue(words.contains(word2));
        assertTrue(words.contains(word1));
    }

    @Test
    void testGetAllWords_EmptyList() {
        // TODO: Implementar el test para getAllWords_EmptyList
        //when
        when(wordRepository.findAllOrdered()).thenReturn(new ArrayList<>());

        //then
        List<WordDTO> result = wordService.getAllWords();
        assertEquals(0, result.size());
        assertNotNull(result);
    }
}

