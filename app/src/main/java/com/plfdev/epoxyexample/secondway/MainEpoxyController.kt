package com.plfdev.epoxyexample.secondway

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel

class MainEpoxyController : EpoxyController() {

    private var mList: List<SectionModel> = listOf()

    override fun buildModels() {
        mList.map { sections ->
            categoriesHolder {
                id(sections.id)
                title(sections.title)
            }

            if (sections.type == "section_carousel") {
                carousel {
                    id("teste")
                    models(getSectionItemCarousel(sections.content))
                }
            } else {
                renderSectionItemList(sections.content)
            }
        }
    }

    private fun renderSectionItemList(sections: List<Section>) {
        sections.map { sectionItem ->
            sectionItemListHolder {
                id(sectionItem.name)
                title(sectionItem.name)
                deepLink(sectionItem.deeplink)
            }
        }
    }

    private fun getSectionItemCarousel(sections: List<Section>): List<SectionItemCarouselHolder_> {
        return sections.map { sectionItem ->
            SectionItemCarouselHolder_()
                .id(sectionItem.name)
                .title(sectionItem.name)
                .deepLink(sectionItem.deeplink)
        }
    }

    fun setData(simpleData: List<SectionModel>) {
        mList = simpleData
        requestModelBuild()
    }
}