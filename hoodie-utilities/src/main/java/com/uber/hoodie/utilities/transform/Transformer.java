/*
 *  Copyright (c) 2018 Uber Technologies, Inc. (hoodie-dev-group@uber.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.uber.hoodie.utilities.transform;

import com.uber.hoodie.common.util.TypedProperties;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Transform source to target dataset before writing
 */
public interface Transformer {

  /**
   * Transform source RDD to target RDD
   *
   * @param jsc JavaSparkContext
   * @param rowDataset Source DataSet
   * @param sparkSession Spark Session
   * @param properties Config properties
   * @return Transformed Dataset
   */
  Dataset<Row> apply(JavaSparkContext jsc, SparkSession sparkSession,
      Dataset<Row> rowDataset, TypedProperties properties);
}
