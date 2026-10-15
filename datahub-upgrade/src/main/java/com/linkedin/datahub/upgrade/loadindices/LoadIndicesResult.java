package com.linkedin.datahub.upgrade.loadindices;

import static com.linkedin.metadata.utils.UnknownDataHandlings.handling;

import lombok.Data;

@Data
public class LoadIndicesResult {
  public int rowsProcessed = 0;
  public int ignored = 0;
  public long timeSqlQueryMs = 0;
  public long timeElasticsearchWriteMs = 0;
  public long unknownToRegistrySkipped = 0;

  @Override
  public String toString() {
    // Reported only when unknown data is tolerated, so the text is unchanged otherwise.
    return handling().isTolerant()
        ? String.format(
            "LoadIndicesResult{rowsProcessed=%d, ignored=%d, timeSqlQueryMs=%d, timeElasticsearchWriteMs=%d, unknownToRegistrySkipped=%d}",
            rowsProcessed,
            ignored,
            timeSqlQueryMs,
            timeElasticsearchWriteMs,
            unknownToRegistrySkipped)
        : String.format(
            "LoadIndicesResult{rowsProcessed=%d, ignored=%d, timeSqlQueryMs=%d, timeElasticsearchWriteMs=%d}",
            rowsProcessed, ignored, timeSqlQueryMs, timeElasticsearchWriteMs);
  }
}
