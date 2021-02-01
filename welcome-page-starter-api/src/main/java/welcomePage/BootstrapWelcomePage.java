package welcomePage;

import io.github.kilmajster.welcomepage.WelcomePage;
import io.github.kilmajster.welcomepage.WelcomePageConfigurationProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class BootstrapWelcomePage implements WelcomePageConfigurationProvider {
    private final WelcomePage.Style style = WelcomePage.Style.BOOTSTRAP;
    private String title;
    private String markdown;
}
