import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.Model.Pessoa;
import com.example.demo.Repositoy.PessoaRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(BundleController.class)
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome da Pessoa");
        pessoa.setDataNascimento("2000-01-01");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa result = pessoaService.criarPessoa(pessoa);

        assertNotNull(result);
        assertEquals("Nome da Pessoa", result.getNome());
        assertEquals("2000-01-01", result.getDataNascimento());
    }

    @Test
    public void testEditarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setNome("Nome da Pessoa");
        pessoa.setDataNascimento("2000-01-01");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa result = pessoaService.editarPessoa(pessoa);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Nome da Pessoa", result.getNome());
        assertEquals("2000-01-01", result.getDataNascimento());
    }

    @Test
    public void testConsultarPessoa() {
        Optional<Pessoa> optionalPessoa = Optional.of(new Pessoa());
        when(pessoaRepository.findById(1)).thenReturn(optionalPessoa);

        Pessoa result = pessoaService.consultarPessoa(1);

        assertNotNull(result);
    }

    @Test
    public void testConsultarPessoaNaoEncontrada() {
        when(pessoaRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.consultarPessoa(1);
        });
    }

    @Test
    public void testConsultarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        pessoas.add(new Pessoa());

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> result = pessoaService.consultarPessoas();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testConsultarPessoasVazia() {
        List<Pessoa> pessoas = new ArrayList<>();

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.consultarPessoas();
        });
    }
}
