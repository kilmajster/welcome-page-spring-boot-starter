package io.github.kilmajster.welcomepage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WelcomePageControllerTests {

    @Mock
    private WelcomePage welcomePage;

    @Spy
    private ModelMap modelMap;

    @InjectMocks
    private WelcomePageController welcomePageController;


    @Test
    public void whenCleanStyleIsSelected_shouldUseCleanStyleTemplate() {
        when(welcomePage.getStyle()).thenReturn(WelcomePage.Style.CLEAN);

        final String template = welcomePageController.welcomePage(modelMap);

        assertThat(template).isEqualTo(WelcomePageController.TEMPLATE_MAIN_PAGE_CLEAN);
        verify(modelMap, times(2)).addAttribute(any(), any());
    }

    @Test
    public void whenBootstrapStyleIsSelected_shouldUseBootstrapStyleTemplate() {
        when(welcomePage.getStyle()).thenReturn(WelcomePage.Style.BOOTSTRAP);

        final String template = welcomePageController.welcomePage(modelMap);

        assertThat(template).isEqualTo(WelcomePageController.TEMPLATE_MAIN_PAGE_BOOTSTRAP);
        verify(modelMap, times(2)).addAttribute(any(), any());
    }

    @Test
    public void whenMaterialDesignStyleIsSelected_shouldUseMaterialDesignStyleTemplate() {
        when(welcomePage.getStyle()).thenReturn(WelcomePage.Style.MATERIAL_DESIGN);
        final String template = welcomePageController.welcomePage(modelMap);

        assertThat(template).isEqualTo(WelcomePageController.TEMPLATE_MAIN_PAGE_MDB);
        verify(modelMap, times(2)).addAttribute(any(), any());
    }
}