package com.linkedin.metadata.search.elasticsearch.query.template;

import com.linkedin.search.template.SearchTemplateProperties;
import io.datahubproject.metadata.context.OperationContext;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;

/**
 * Stored search-template aspects read from the entity index. A URN that is absent was not in the
 * index. An empty value is a document that does not yet carry the template body.
 */
public interface SearchTemplateDocuments {
  @Nonnull
  Map<String, Optional<SearchTemplateProperties>> read(
      @Nonnull OperationContext opContext, @Nonnull Collection<String> urns);
}
