package org.yashkov.cafs

import kotlin.io.path.Path
import java.net.URI
import java.nio.file.FileSystemAlreadyExistsException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CaFileSystemProviderTest {
    private val none = emptyMap<String, Any>()

    private val provider = CaFileSystemProvider()

    @Test
    fun newFileSystem_ThrowsException_WhenNonFileUri() {
        assertThatThrownBy {
            provider.newFileSystem(URI.create("http://localhost/"), none)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("not 'file' URI: 'http://localhost/'")
    }

    @Test
    fun newFileSystem_ThrowsException_WhenDuplicateUri() {
        provider.newFileSystem(URI.create("file:///dir"), none)

        assertThatThrownBy {
            provider.newFileSystem(URI.create("file:///dir"), none)
        }.isInstanceOf(FileSystemAlreadyExistsException::class.java)
            .hasMessage("file:///dir")

    }

    @Test
    fun newFileSystem_ReturnsCreatedFilesystem_WhenValidUniqueUri() {
        val fs1 = provider.newFileSystem(URI.create("file:///fs1"), none)
        val fs2 = provider.newFileSystem(URI.create("file:///fs2"), none)

        assertThat(fs1).isNotNull
        assertThat(fs2).isNotNull
        assertThat(fs2).isSameAs(fs2)
    }

    @Nested
    inner class FileSystem {
        private val fileSystem = provider.newFileSystem(
            URI.create("file:///dir"), none)

        @Test
        fun provider_ReturnsProviderInstance_Always() {
            assertThat(fileSystem.provider()).isSameAs(provider)
        }

        @Test
        fun getRootDirectories_ReturnsSingleRoot_Always() {
            assertThat(fileSystem.rootDirectories).containsExactly(Path(""))
        }

        @Test
        fun getSeparator_ReturnsSlash_Always() {
            assertThat(fileSystem.separator).isEqualTo("/")
        }
    }
}
