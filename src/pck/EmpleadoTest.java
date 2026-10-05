package pck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pck.Empleado.TipoEmpleado;

public class EmpleadoTest {
	
	// calculoNominaEmpleado (8 pruebas)
	
	@Test
    public void testVentaMenorQue1000() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Vendedor, 999f, 0f);
        assertEquals(-1f, res, 0.001);
    }

    @Test
    public void testVentaLimiteInferiorExacto() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Vendedor, 1000f, 0f);
        assertEquals(2100f, res, 0.001);
    }

    @Test
    public void testVentaJustoEncimaDelLimiteInferior() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Vendedor, 1001f, 0f);
        assertEquals(2100f, res, 0.001);
    }

    @Test
    public void testVentaLimiteSuperiorExacto() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Encargado, 1500f, 0f);
        assertEquals(2700f, res, 0.001);
    }

    @Test
    public void testVentaJustoDebajoDelLimiteSuperior() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Encargado, 1499f, 0f);
        assertEquals(2600f, res, 0.001);
    }

    @Test
    public void testHorasExtraNegativas() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Vendedor, 1200f, -1f);
        assertEquals(-1f, res, 0.001);
    }

    @Test
    public void testHorasExtraCero() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Vendedor, 1200f, 0f);
        assertEquals(2100f, res, 0.001);
    }

    @Test
    public void testHorasExtraPositivas() {
        float res = Empleado.CalculaNominaEmpleado(TipoEmpleado.Encargado, 1200f, 5f);
        assertEquals(2750f, res, 0.001);
    }

    
    // calculoNominaNeta (5 pruebas)

    @Test
    public void testNetaNegativa() {
        float res = Empleado.calculoNominaNeta(-1f);
        assertEquals(-1f, res, 0.001);
    }

    @Test
    public void testNetaCero() {
        float res = Empleado.calculoNominaNeta(0f);
        assertEquals(0f, res, 0.001);
    }

    @Test
    public void testNetaLimite2100() {
        float res = Empleado.calculoNominaNeta(2100f);
        assertEquals(2100f, res, 0.001);
    }

    @Test
    public void testNetaEntre2100y2500() {
        float res = Empleado.calculoNominaNeta(2300f);
        assertEquals(1955f, res, 0.001);
    }

    @Test
    public void testNetaMayor2500() {
        float res = Empleado.calculoNominaNeta(2501f);
        assertEquals(2050.82f, res, 0.001);
    }

	/*@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
