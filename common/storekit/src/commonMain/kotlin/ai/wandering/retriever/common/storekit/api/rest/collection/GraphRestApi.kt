package ai.wandering.retriever.common.storekit.api.rest.collection

import ai.wandering.retriever.common.storekit.api.rest.RestApi
import ai.wandering.retriever.common.storekit.entity.Graph

interface GraphRestApi : RestApi<String, Graph.Output.Unpopulated, Graph.Network>