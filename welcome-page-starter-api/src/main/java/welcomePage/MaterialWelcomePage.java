package welcomePage;

import io.github.kilmajster.welcomepage.WelcomePage;
import io.github.kilmajster.welcomepage.WelcomePageConfigurationProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import static io.github.kilmajster.welcomepage.WelcomePage.loadFromUrl;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class MaterialWelcomePage implements WelcomePageConfigurationProvider {
    private final WelcomePage.Style style = WelcomePage.Style.MATERIAL_DESIGN;
    private String title;
    private String markdown;

    public MaterialWelcomePage withMarkdownFrom(final String url) {
        this.markdown = loadFromUrl(url);
        return this;
    }
}
